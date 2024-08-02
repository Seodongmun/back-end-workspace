// video-card 눌렀을때 페이징 처리
const videoCard = document.querySelectorAll('.video-card');

videoCard.forEach(card => {
	card.addEventListener('click', () => {
		const code = card.getAttribute("data-code");
		console.log(code);
		window.location.href = "/" + code;
		

	});
});