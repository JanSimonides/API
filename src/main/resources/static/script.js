var inputs = []

var i;
for (i=1;i<=2;i++){
    inputs[i] = document.getElementById('p'+i);
}

var btnCheck = document.getElementById('btnCheck');
var btn = document.getElementById("btn");
var description = document.getElementById('description');
btn.disabled = true;

//console.log(inputs[1].value)
//console.log(inputs[2].value)

btnCheck.addEventListener("click", function(){
    for (i = 1; i < inputs.length; i++) {
         for(j = 1; j < inputs.length; j++){
            if (i != j){
                if (inputs[i].value == inputs[j].value){
                    btn.disabled = true;
                }
                else{
                    btn.disabled = false;
                }
            }


         }
    }
});

