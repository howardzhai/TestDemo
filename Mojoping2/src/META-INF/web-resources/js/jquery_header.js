$(document).ready(function(){
/*$('a').mouseenter(function () {
    $(this).css({border: '0 solid #f37736'}).animate({
        borderWidth: 4
    }, 500);
}).mouseleave(function () {
     $(this).animate({
        borderWidth: 0
    }, 500);
}); */
$('a').mouseenter(function () {
    $(this).animate({
        borderColor: '#ffffff'
    }, 500);
}).mouseleave(function () {
     $(this).animate({
        borderColor: 'transparent'
    }, 500);
}); 
});