//This is how you'd get the tags for the review using fetch, but that won't refresh the list unless you refresh the page
// fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags`, {method: 'get'})
// 	.then(res => res.json())
// 	.then(data=> {
// 		const tagsArea = document.querySelector('.tags-area')
// 		const list = document.createElement('ul')
// 		data.forEach(tag =>{
// 			let item = document.createElement('li')
// 			item.innerHTML = `<a href="#">${tag.name}</a>`
// 			list.appendChild(item)
// 		})
// 		tagsArea.appendChild(list)
// 	}
// )

const tagsUl = document.querySelector('.tags-ul')

loadTags()

function loadTags() {
	const xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    	populateTags(JSON.parse(this.responseText))
    }
  }
  	xhttp.open("GET", `/api/reviews/${window.location.pathname.split('/')[2]}/tags`, true);  //this is the this.responseText
  	xhttp.send();
}

function populateTags(allTags) {
	clearTagList()
    allTags.forEach(tag=>{
		let item = document.createElement('li')
		item.innerHTML = `<a href="/api/tags/${tag.id}">${tag.name}</a>`
																						//TODO - rewrite that anchor link to go to the tag's HTML, not the API
		tagsUl.appendChild(item)
	})
}

function clearTagList() {
	tagsUl.innerHTML = ''
}

const newTagButton = document.querySelector('.new-tag-button')
const newTagField = document.querySelector('.new-tag-field')
setupNewTagButton(newTagButton, newTagField)

function setupNewTagButton(button, tagField) {
	button.addEventListener('click', function() {
		const newTagName = tagField.value
		fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, {
			method: `POST`,
			body: newTagName
		})
		loadTags()
	})
}


//ADD TAGS

// const addTagButton = document.querySelector('.new-tag-button')
// const newTagField = document.querySelector('.new-tag-field')
// addTagButton.addEventListener('click', function() {
// 	const newTagName = newTagField.value
// 	fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, {
// 		method: `POST`,
// 		body: newTagName
// 	})

// })