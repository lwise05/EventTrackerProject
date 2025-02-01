console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('Document loaded')
	init();
})

function init() {
	console.log('In init()')
	loadComedyEventList();

	//TODO: event listeners for HTML form buttons, etc.
	document.addComedyEventForm.submit.addEventListener('click', function(e){
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

function loadComedyEventList() {
	// XHR to hit my list API endpoint
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/comedyEvents');

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				// * On success, if a response was received parse the film data
				let comedyEvents = JSON.parse(xhr.responseText);
				console.log(comedyEvents);

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
		let td = document.createElement('td');
		let img = document.createElement('img');
		img.src = event.comedian.imageUrl
		img.alt = "Image of " + event.comedian.firstName + " " + event.comedian.lastName;
		img.classList.add('w-25');
		
		td.appendChild(img);
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = event.comedian.firstName + " " + event.comedian.lastName;
		tr.appendChild(td);
		
		tr.comedianId = event.comedian.id;
		tr.addEventListener('click', function(e){
			comedianId = e.target.parentElement.comedianId;
			console.log(e.target.parentElement);
		})
		
		td = document.createElement('td');
		td.textContent = event.performanceDate;
		tr.appendChild(td);
		
		td = document.createElement('td');
		td.textContent = event.rating;
		tr.appendChild(td);
		
		tbody.appendChild(tr);
	}
	
function addComedyEvent(newComedyEvent){
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
	
	
}