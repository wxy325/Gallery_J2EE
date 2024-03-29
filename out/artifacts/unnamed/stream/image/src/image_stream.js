/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-1
 * Time: 下午11:01
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function() {
    //vendor script
    $('#header')
        .css({ 'top':-50 })
        .delay(1000)
        .animate({'top': 0}, 800);

    $('#footer')
        .css({ 'bottom':-15 })
        .delay(1000)
        .animate({'bottom': 0}, 800);

    //blocksit define
    $(window).load( function() {
        $('#container').BlocksIt({
            numOfCol: 5,
            offsetX: 8,
            offsetY: 8
        });
    });

    //window resize
    var currentWidth = 1100;
    $(window).resize(function() {
        var winWidth = $(window).width();
        var conWidth;
        if(winWidth < 660) {
            conWidth = 440;
            col = 2
        } else if(winWidth < 880) {
            conWidth = 660;
            col = 3
        } else if(winWidth < 1100) {
            conWidth = 880;
            col = 4;
        } else {
            conWidth = 1100;
            col = 5;
        }

        if(conWidth != currentWidth) {
            currentWidth = conWidth;
            $('#container').width(conWidth);
            $('#container').BlocksIt({
                numOfCol: col,
                offsetX: 8,
                offsetY: 8
            });
        }
    });
});