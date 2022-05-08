
function createElement3d(selector,imgsrc){
const myArray = imgsrc.split("_$");
numberMain = myArray[myArray.length-2];
//console.log(numberMain)
var current;
var i=0;
$('#'+selector).draggable({
    axis: "x",
	revert: 'invalid',
    helper: 'clone',
	activeClass: "ui-state-hover",
	hoverClass: "ui-state-active",
    drag: function(event, ui) {
         $(ui.helper).remove(); //destroy clone
		diff = ui.position.left-current;
		current = ui.position.left;
		if(Math.abs(diff)>0.5){
			//console.log('has moved ' + ((diff < 1) ? 'rigth':'left'))
			if(diff < 1){
				n=1;
			}else{
				n=-1;
			}
			
			i=i+n;
			if(i<number){
				i=0;
			}else if(i>0){
				i=-numberMain;
			}
			//console.log(i)
			//var img = new Image(); 
			//img.onload = function(){       
				ctx.drawImage(img,oneWidth*i,0);               
			//};       
			//img.src = imgsrc;
    	}
    },
    start: function(event, ui) {
        current = ui.position.left;
        //console.log('has moved ' + ((right < left) ? 'rigth':'left'))
    }
});



  var c = document.getElementById(selector);
  var ctx = c.getContext("2d");
  var img = new Image(); 
  img.onload = function(){     
	width = this.width;
	ctx.canvas.height = this.height;
	oneWidth = width/numberMain  
	ctx.canvas.width = oneWidth;
    ctx.drawImage(img,-1*oneWidth,0);    
  
  number = -width/oneWidth;
  //console.log(number)	
};           
  img.src = imgsrc; 
  

  
}

