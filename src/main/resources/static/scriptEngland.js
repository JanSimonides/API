var inputs = [];
var i,j;
for (i=1;i<=20;i++){
  inputs[i] = document.getElementById("p"+i);
}

var btnCheck = document.getElementById('btnCheck');
var btn = document.getElementById("btn");
var options = ["Manchester City", "Manchester United", "Chelsea", "Arsenal", "Liverpool", "Spurs", "West Ham", "Newcastle", "Wolverhampton", "Leeds",
               "Leicester", "Brighton", "West Brom", "Everton", "Sheffield", "Crystal Palace", "Burnley", "Aston Villa", "Southampton", "Fulham"];

for (j =1; j <inputs.length; j++) {
    for(i = 0; i < options.length; i++) {
        var opt = options[i];
        var el = document.createElement("option");
        el.textContent = opt;
        el.value = opt;
        inputs[j].appendChild(el);
    }
}

btn.disabled = true;

btnCheck.addEventListener("click", function(){
    var result = false;
    for (i = 1; i < inputs.length; i++) {
         for(j = 1; j < inputs.length; j++){
            if (i != j){
            //console.log(inputs[i].value+" "+inputs[j].value)
                if (inputs[i].value == inputs[j].value){

                    result = true;
                }
            }
         }
         if(inputs[i].value =="null"){
            result = true;
         }
    }

    if(result){
        btn.disabled = true;
    }
    else{
        btn.disabled = false;
    }
});