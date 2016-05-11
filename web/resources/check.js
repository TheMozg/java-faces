function imgClickHandler(ClickEvent)
{
    var parrentPos = getPosition(ClickEvent.currentTarget);
    var xPos = ClickEvent.clientX - parrentPos.x;
    var yPos = ClickEvent.clientY - parrentPos.y;
    //alert('hello2');

    var height = ClickEvent.currentTarget.clientHeight;
    var width  = ClickEvent.currentTarget.clientWidth;
   // xScaled = 2*(xPos - height/2)/height;
 //   yScaled = -2*(yPos - width/2)/width;
    //alert('hello3');


    //r = document.getElementById('Rval').value;

//    var yVal = yScaled*r;
//    var xVal = xScaled*r;


    var yVal = height/2 - yPos;
    var xVal = xPos - width/2;
    //alert('hello4');


    yVal = (8*yVal)/height;
    xVal = (8*xVal)/width;
    //alert('hello');

    //alert(xVal + " " + yVal);
    //alert('hello6');

    document.getElementById('mainForm:hiddenx').value = xVal;
    document.getElementById('mainForm:y').value = yVal;

    document.getElementById('mainForm:hiddenSubmit').click();
}

function getPosition(element)
{
    var xPos = 0;
    var yPos = 0;

    while(element)
    {
        xPos += (element.offsetLeft - element.scrollLeft + element.clientLeft);
        yPos += (element.offsetTop - element.scrollTop + element.clientTop);
        element = element.offsetParent;
    }

    return {x: xPos, y:yPos};
}