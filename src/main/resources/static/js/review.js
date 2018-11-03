fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags`, {method: 'get'})
	.then(res => res.json())
	.then(data=> {
		const tagsArea = document.querySelector('.tags-area')
		const list = document.createElement('ul')
		data.forEach(tag =>{
			let item = document.createElement('li')
			item.innerHTML = `<a href="#">${tag.name}</a>`
			list.appendChild(item)
		})
		tagsArea.appendChild(list)
	}
)



const addTagButton = document.querySelector('.new-tag-button')
const newTagField = document.querySelector('.new-tag-field')
addTagButton.addEventListener('click', function() {
	const newTagName = newTagField.value
	fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, {
		method: `POST`,
		body: newTagName
	})

})