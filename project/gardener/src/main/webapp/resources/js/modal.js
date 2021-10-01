$(document).ready(function( $ ){     
    $(".open1").on("click", function(event) { 
    $("#popup01").show();  
    $("body").append('<div class="backon"></div>');
    });
    
    $("body").on("click", function(event) { 
        if(event.target.className == 'close' || event.target.className == 'backon'){
            $("#popup01").hide();
      	    $(".backon").hide();
        }
      });

  });


  $(document).ready(function( $ ){     
    $(".open2").on("click", function(event) { 
    $("#popup02").show();  
    $("body").append('<div class="backon"></div>');
    });
    
    $("body").on("click", function(event) { 
        if(event.target.className == 'close' || event.target.className == 'backon'){
            $("#popup02").hide();
      	    $(".backon").hide();
        }
      });

  });