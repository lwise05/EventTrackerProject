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

				//   and pass the film object to displayComedyEvents().			
				displayComedyEvents(comedyEvents);

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
	addEventForm(comedyEvents);
	//let addEventButton = document.createElement('button');
	//addEventButton.textContent = "Add a Comedy Show";
	//addEventButton.classList.add('btn', 'btn-primary');
	//addEventButton.addEventListener('click', function(e) {
	//addEventForm(comedyEvents);
	//	});

	let eventDiv = document.getElementById("comedyEventList");
	let addEventDiv = document.getElementById("addComedyEvent");
	eventDiv.style.display = 'block';
	//addEventDiv.style.display = 'none';
	//eventDiv.appendChild(addEventButton);

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


	let editButton = document.createElement('button');
	editButton.textContent = 'Edit Comedy Show';
	editButton.classList.add('btn', 'btn-primary');
	editButton.addEventListener('click', function(e) {
		e.preventDefault();
		editComedyEvent(comedyEvent)

	});
	eventDiv.appendChild(editButton);


	let deleteButton = document.createElement('button');
	deleteButton.textContent = 'Delete Comedy Show';
	deleteButton.classList.add('btn', 'btn-primary');
	deleteButton.addEventListener('click', function(e) {
		e.preventDefault();
		deleteComedyEvent(comedyEvent.id)

	});
	eventDiv.appendChild(deleteButton);


	showAllEventDetails()

}

function showAllEventDetails() {

	let detailsDiv = document.getElementById("comedyEventDetails");
	let eventListDiv = document.getElementById("comedyEventList");
	let comedyEventFormDiv = document.getElementById("addComedyEvent");

	detailsDiv.style.display = 'block';
	eventListDiv.style.display = 'none';
	comedyEventFormDiv.style.display = 'none';
}

function showList() {

	let detailsDiv = document.getElementById("comedyEventDetails");
	let eventListDiv = document.getElementById("comedyEventList");
	let comedyEventFormDiv = document.getElementById("addComedyEvent");

	detailsDiv.style.display = 'none';
	eventListDiv.style.display = 'block';
	comedyEventFormDiv.style.display = 'block';
}


function addEventForm() {

	//for (let event of comedyEvents) {
	//	let selectFirstName = document.getElementById('firstName');
	//	let firstNameOpt = document.createElement('option');
	//	firstNameOpt.value = event.comedian.id;
	//	firstNameOpt.textContent = event.comedian.firstName + " " + event.comedian.lastName;
	//	selectFirstName.appendChild(firstNameOpt);
	//	let selectVenue = document.getElementById('venue');
	//	let venueOpt = document.createElement('option');
	//	venueOpt.value = event.venue.id;
	//	venueOpt.textContent = event.venue.name;
	//	selectVenue.appendChild(venueOpt);
	//};

	//let eventListDiv = document.getElementById("comedyEventList");
	let addEventtDiv = document.getElementById("addComedyEvent");
	//addEventtDiv.style.display = 'block';

	let form = document.createElement('form');
	form.name = "addComedyEventForm"
	addEventtDiv.appendChild(form);

	let date = document.createElement('input');
	date.type = 'date';
	date.name = 'performanceDate';
	form.appendChild(date);

	let select = document.createElement('select');
	select.id = 'category';
	select.name = 'category';
	form.appendChild(select);

	let option = document.createElement('option');
	option.value = '1';
	option.textContent = 'Anecdotal (story telling)';
	select.appendChild(option);

	option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Observational (everyday life humor) (story telling)';
	select.appendChild(option);
	////////////////////////////// TODO: Add all categories

	select = document.createElement('select');
	select.id = 'comedian';
	select.name = 'comedian';
	form.appendChild(select);

	option = document.createElement('option');
	option.value = '1';
	option.textContent = 'Beth Stelling';
	select.appendChild(option);

	option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Joel Kim Booster';
	select.appendChild(option);


	select = document.createElement('select');
	select.id = 'venue';
	select.name = 'venue';
	form.appendChild(select);

	option = document.createElement('option');
	option.value = '1';
	option.textContent = 'Comedy Works Downtown';
	select.appendChild(option);

	option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Comedy Works South';
	select.appendChild(option);

	let ticketPrice = document.createElement('input');
	ticketPrice.type = "number";
	ticketPrice.name = 'ticketPrice';
	form.appendChild(ticketPrice);

	let rating = document.createElement('input');
	rating.type = "number";
	rating.name = 'rating';
	form.appendChild(rating);

	let submit = document.createElement('input');
	submit.type = 'submit';
	submit.name = 'submit';
	submit.value = 'Submit';
	form.appendChild(submit);


	document.addComedyEventForm.submit.addEventListener('click', function(e) {
		//e.preventDefault();


		let newComedyEvent = {
			performanceDate: addComedyEventForm.performanceDate.value,
			category: addComedyEventForm.category.value,
			comedian: {
				id: addComedyEventForm.comedian.value,
			},
			venue: {
				id: addComedyEventForm.venue.value,
			},
			ticketPrice: addComedyEventForm.ticketPrice.value,
			rating: addComedyEventForm.rating.value,
		};




		//let newComedyEvent = {
		//'performanceDate': addComedyEventForm.performanceDate.value,
		//'comedian.id': addComedyEventForm.comedian_id.value,
		//'comedian.lastName': addComedyEventForm.lastName.value,
		//'comedian.category': addComedyEventForm.category.value,
		//'venue.id': addComedyEventForm.venueId.value,
		//'venue.name': addComedyEventForm.name.value,
		//'venue.street': addComedyEventForm.street.value,
		//'venue.street2': addComedyEventForm.street2.value,
		//'venue.city': addComedyEventForm.city.value,
		//'venue.state': addComedyEventForm.state.value,
		//'venue.postalCode': addComedyEventForm.postalCode.value,
		//'venue.country': addComedyEventForm.country.value,
		//'ticketPrice': addComedyEventForm.ticketPrice.value,
		//'rating': addComedyEventForm.rating.value,
		//'notes': addComedyEventForm.notes.value,
		//};

		addComedyEvent(newComedyEvent);
		addComedyEventForm.reset();

	});


}



function addComedyEvent(newComedyEvent) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/comedyEvents');

	// speficy the type of request body you're sending
	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200 || xhr.status === 201) {
				// * On success, if a response was received parse the event data
				let newComedyEvent = JSON.parse(xhr.responseText);


			}
			else {
				// * On failure, provide error feedback			
				console.error('Unable to complete request and add event to DB')
				console.error(xhr.status + ' : ' + xhr.responseText)
			}
		}
	}


	let newEventJson = JSON.stringify(newComedyEvent);
	console.log(newEventJson);

	xhr.send(newEventJson);


}



function editComedyEvent(comedyEvent) {
	let comedyEventListDiv = document.getElementById('comedyEventList');
	let comedyEventDetailsDiv = document.getElementById('comedyEventDetails');
	let addComedyEventDiv = document.getElementById('addComedyEvent');
	let editComedyEventDiv = document.getElementById('editComedyEvent');


	comedyEventListDiv.style.display = 'none';
	comedyEventDetailsDiv.style.display = 'none';
	addComedyEventDiv.style.display = 'none';
	editComedyEventDiv.style.display = 'block';


	let updateForm = document.createElement('form');
	updateForm.name = updateForm;
	editComedyEventDiv.appendChild(updateForm);

	let date = document.createElement('input');
	date.type = 'date';
	date.name = 'performanceDate';
	date.value = comedyEvent.performanceDate;
	updateForm.appendChild(date);

	let select = document.createElement('select');
	select.id = 'category';
	select.name = 'category';
	select.value = comedyEvent.category;
	updateForm.appendChild(select);

	let option = document.createElement('option');
	option.value = '1';
	option.textContent = 'Anecdotal (story telling)';
	select.appendChild(option);

	option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Observational (everyday life humor) (story telling)';
	select.appendChild(option);
	////////////////////////////// TODO: Add all categories

	select = document.createElement('select');
	select.id = 'comedian';
	select.name = 'comedian';
	select.value = comedyEvent.comedian;
	updateForm.appendChild(select);

	option = document.createElement('option');
	option.value = '1';
	option.textContent = 'Beth Stelling';
	select.appendChild(option);

	option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Joel Kim Booster';
	select.appendChild(option);


	select = document.createElement('select');
	select.id = 'venue';
	select.name = 'venue';
	select.value = comedyEvent.venue;
	updateForm.appendChild(select);

	option = document.createElement('option');
	option.value = '1';
	option.textContent = 'Comedy Works Downtown';
	select.appendChild(option);

	option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Comedy Works South';
	select.appendChild(option);

	let ticketPrice = document.createElement('input');
	ticketPrice.type = "number";
	ticketPrice.name = 'ticketPrice';
	select.value = comedyEvent.ticketPrice;
	updateForm.appendChild(ticketPrice);

	let rating = document.createElement('input');
	rating.type = "number";
	rating.name = 'rating';
	select.value = comedyEvent.rating;
	updateForm.appendChild(rating);

	let submit = document.createElement('input');
	submit.type = 'submit';
	submit.name = 'submit';
	submit.value = 'Submit';
	updateForm.appendChild(submit);


	submit.addEventListener('click', function(e) {
		e.preventDefault();
		let updatedComedyEvent = {
			id: comedyEvent.id,
			performanceDate: updateForm.performanceDate.value,
			category: updateForm.category.value,
			comedian: {
				id: updateForm.comedian.value,
			},
			venue: {
				id: updateForm.venue.value,
			},
			ticketPrice: updateForm.ticketPrice.value,
			rating: updateForm.rating.value,
		};

		updateComedyEvent(updatedComedyEvent);
		updateForm.reset();

	});

}


function updateComedyEvent(updatedComedyEvent) {

	let xhr = new XMLHttpRequest();

	xhr.open('PUT', `api/comedyEvents/${updatedComedyEvent.id}`);

	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let comedyEvent = JSON.parse(xhr.responseText);
				displayComedyEvent(comedyEvent.id);
			}
		}

		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}

	};
	let updatedComedyEventJson = JSON.stringify(updatedComedyEvent);
	xhr.send(updatedComedyEventJson);


}

function deleteComedyEvent(comedyEventId) {
	let xhr = new XMLHttpRequest();

	xhr.open('DELETE', `api/comedyEvents/${comedyEventId}`);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 204 || xhr.status === 200) {
				console.log("deleted " + comedyEventId);
				init();
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	}
	xhr.send();


}


