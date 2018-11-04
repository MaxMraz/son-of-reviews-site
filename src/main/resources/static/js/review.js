const currentReviewId = window.location.pathname.split('/')[2]
const tagsUl = document.querySelector('.tags-ul')

loadTags(tagsUl)

function loadTags(tagsUl) {
	var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    	populateTags(JSON.parse(this.responseText), tagsUl)
    }
  }
  	xhttp.open("GET", `/api/reviews/${currentReviewId}/tags`, true);  //this is the this.responseText
  	xhttp.send();
}

function populateTags(allTags, tagsUl) {
	clearTagList(tagsUl)
    allTags.forEach(tag=>{
		let item = document.createElement('li')
		item.innerHTML = `
			<div>
				<a href="/tags/${tag.id}">${tag.name}</a>
				<button id="${tag.name}" class="tag-delete-button">Remove Tag</button>
			</div>`
		tagsUl.appendChild(item)
		setupDeleteButtons(scanForDeleteButtons(), tagsUl)		//SETUP DELETE BUTTONS AS THEY'RE CREATED
	})
}

function clearTagList(tagsUl) {
	tagsUl.innerHTML = ''
}



////////////////////////////////////////ADDING TAGS/////////////////////////////////////////////////////


const newTagButton = document.querySelector('.new-tag-button')
const newTagField = document.querySelector('.new-tag-field')
setupNewTagButton(newTagButton, newTagField, tagsUl)

function setupNewTagButton(button, tagField, tagsUl) {
	button.addEventListener('click', function() {
		const newTagName = tagField.value
		fetch(`/api/reviews/${currentReviewId}/tags/add`, {
			method: `POST`,
			body: newTagName
		})
		tagField.value = ''
		loadTags(tagsUl)
		loadTags(tagsUl)
		loadTags(tagsUl) //I can't figure out why I have to do this 3 times but... otherwise the tag won't load into the list until the next load
	})
}



/////////////////////////////////////REMOVING TAGS//////////////////////////////////////////////


function scanForDeleteButtons() {
	let buttons = document.querySelectorAll('.tag-delete-button')
	return buttons
}


function setupDeleteButtons(buttons, tagsUl) {
	buttons.forEach(button => {
		button.addEventListener('click', function(button) {
			//for reasons I don't understand, button.id does not return the id of the element. But you can get to the id this way:
			let tagName = button.path[0].id
			fetch(`/api/reviews/${currentReviewId}/tags/remove`, {
				method: `POST`,
				body: tagName
			})
			loadTags(tagsUl)
			loadTags(tagsUl)
			loadTags(tagsUl) //Still not sure why, but gonna play it safe
		})
	})
}