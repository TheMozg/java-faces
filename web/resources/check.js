function imgClickHandler(ClickEvent)
{
    var parrentPos = getPosition(ClickEvent.currentTarget);
    var xPos = ClickEvent.clientX - parrentPos.x;
    var yPos = ClickEvent.clientY - parrentPos.y;

    var height = ClickEvent.currentTarget.clientHeight;
    var width  = ClickEvent.currentTarget.clientWidth;


    var yVal = height/2 - yPos;
    var xVal = xPos - width/2;

    yVal = (8*yVal)/height;
    xVal = (8*xVal)/width;

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