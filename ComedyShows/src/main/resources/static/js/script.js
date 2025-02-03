console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('Document loaded')
	init();
})

function init() {
	console.log('In init()')
	loadComedyEventList();

	//TODO: event listeners for HTML form buttons, etc.

}

function loadComedyEventList() {
	// XHR to hit my list API endpoint
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/comedyEvents');

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				// * On success, if a response was received parse the film data
				let comedyEvents = JSON.parse(xhr.responseText);
				//console.log(comedyEvents);

				//   and pass the film object to displayFilm().			
				displayComedyEvents(comedyEvents)
			}
		}
	}

	xhr.send();


}

function displayComedyEvents(comedyEvents) {

	//DOM to build table rows
	let tbody = document.getElementById("eventListTbody")
	tbody.textContent = '';

	for (let event of comedyEvents) {
		let tr = document.createElement('tr');

		let img = document.createElement('img');
		img.src = event.comedian.imageUrl
		img.alt = "Image of " + event.comedian.firstName + " " + event.comedian.lastName;
		img.classList.add('w-25');

		let td = document.createElement('td');
		td.appendChild(img);
		td.comedyEventId = event.id;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = event.comedian.firstName + " " + event.comedian.lastName;
		//td.comedianId = event.comedian.id;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = event.performanceDate;
		td.comedianId = event.comedian.id;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = event.rating;
		//td.comedianId = event.comedian.id;
		tr.appendChild(td);

		tr.comedyEventId = event.id;

		tr.addEventListener('click', function(e) {
			comedyEventId = e.target.parentElement.comedyEventId;
			console.log(comedyEventId);
			getComedyEvent(comedyEventId);
		});

		tbody.appendChild(tr);
	}
	let addEventButton = document.createElement('button');
	addEventButton.textContent = "Add a Comedy Show";
	addEventButton.classList.add('btn', 'btn-primary');
	addEventButton.addEventListener('click', function(e) {
		addEventForm();
	})

	let eventDiv = document.getElementById("comedyEventList");
	eventDiv.appendChild(addEventButton);

}

function getComedyEvent(comedyEventId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', `api/comedyEvents/${comedyEventId}`);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				// * On success, if a response was received parse the film data
				let comedyEvent = JSON.parse(xhr.responseText);

				displayComedyEvent(comedyEvent);
			}

		}
	};

	xhr.send();


}

function displayComedyEvent(comedyEvent) {
	let eventDiv = document.getElementById("comedyEventDetails");
	eventDiv.textContent = "";

	let img = document.createElement('img');
	img.src = comedyEvent.comedian.imageUrl;
	img.alt = "Image of " + comedyEvent.comedian.firstName + " " + comedyEvent.comedian.lastName;
	img.classList.add('comedian-image');
	eventDiv.appendChild(img);

	let h3 = document.createElement('h3');
	h3.textContent = comedyEvent.comedian.firstName + " " + comedyEvent.comedian.lastName;
	eventDiv.appendChild(h3);

	let p = document.createElement('p');
	p.textContent = "Performance date: " + comedyEvent.performanceDate;
	eventDiv.appendChild(p);

	p = document.createElement('p');
	p.textContent = "Location: " + comedyEvent.venue.name;
	eventDiv.appendChild(p);

	p = document.createElement('p');
	p.textContent = "Ticket Price: $" + comedyEvent.ticketPrice;
	eventDiv.appendChild(p);

	p = document.createElement('p');
	p.textContent = "Rating: " + comedyEvent.rating;
	eventDiv.appendChild(p);

	p = document.createElement('p');
	p.textContent = "Show notes: " + comedyEvent.notes;
	eventDiv.appendChild(p);

	let backButton = document.createElement('button');
	backButton.textContent = "Return to List";
	backButton.classList.add('btn', 'btn-primary');
	backButton.addEventListener('click', function(e) {
		showList();
	})

	eventDiv.appendChild(backButton);

	showAllEventDetails()

}

function showAllEventDetails() {

	let detailsDiv = document.getElementById("comedyEventDetails");
	let eventListDiv = document.getElementById("comedyEventList");

	detailsDiv.style.display = 'block';
	eventListDiv.style.display = 'none';
}

function showList() {

	let detailsDiv = document.getElementById("comedyEventDetails");
	let eventListDiv = document.getElementById("comedyEventList");

	detailsDiv.style.display = 'none';
	eventListDiv.style.display = 'block';
}


function addEventForm() {

	let eventListDiv = document.getElementById("comedyEventList");
	let addEventtDiv = document.getElementById("addComedyEvent");

	addEventtDiv.style.display = 'block';
	eventListDiv.style.display = 'none';




	document.addComedyEventForm.submit.addEventListener('click', function(e) {
		e.preventDefault();

		let newComedyEvent = {
			performanceDate: addComedyEventForm.performanceDate.value,
			rating: addComedyEventForm.rating.value,
			ticketPrice: addComedyEventForm.ticketPrice.value,
			notes: addComedyEventForm.notes.value,
			venue: addComedyEventForm.venue.value,
			comedian: addComedyEventForm.comedian.value,
		}

		addComedyEvent(newComedyEvent);
		addComedyEventForm.reset();
	});

}


function addComedyEvent(newComedyEvent) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/comedyEvents');////////////************************ */

	// speficy the type of request body you're sending
	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200 || xhr.status === 201) {
				// * On success, if a response was received parse the film data
				let newFilm = JSON.parse(xhr.responseText);

				//   and pass the film object to displayFilm().			
				displayFilm(newFilm);

			}
			else {
				// * On failure, provide error feedback			
				console.error('Unable to complete request and add film to DB')
				console.error(xhr.status + ' : ' + xhr.responseText)
			}
		}
	}

	//javascript object constructed in init function


	// convert JS obj to JSON

	let newFilmJson = JSON.stringify(newFilm);
	console.log(newFilmJson);

	xhr.send(newFilmJson);


}


