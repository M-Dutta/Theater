var images = ['universe.jpg']
$(document).ready(function() {
    var i = 0;
    $('.parallax').each(function () {
        $(this).parallax({
            imageSrc: 'img/' + images[i],
            bleed: '200',
            speed: '.2'
        });
        i++;
    });
});
