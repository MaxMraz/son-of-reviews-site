const {
	loadTags,
	populateTags,
	clearTagList,
	setupNewTagButton,
	scanForDeleteButtons,
	setupDeleteButtons
} = require('../js/dom.js')


const tagsUl = document.createElement('ul')
const newTagButton = document.createElement('button')
newTagButton.classList.add('new-tag-button')
const newTagField = document.createElement('input')
newTagField.classList.add('new-tag-field')
newTagField.type = "text"
newTagField.name = "tag-input"

describe('ShowTags', ()=> {


	
})