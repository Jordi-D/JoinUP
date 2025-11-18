document.querySelectorAll(".btn[data-paso]").forEach(btn => {
    btn.addEventListener("click", () => {
        const n = btn.dataset.paso;

        // Apagar todos los círculos
        document.querySelectorAll(".paso").forEach(s => s.classList.remove("activo"));

        // Encender círculo correspondiente
        document.getElementById("pasoCirculo" + n).classList.add("activo");
    });
});

//JS para los intereses
const intereses = document.querySelectorAll('label.interes');
let seleccionados = []; 

intereses.forEach(interes => {
    interes.addEventListener('click', () => {

        
        if (interes.classList.contains('selected')) {
            interes.classList.remove('selected');
            seleccionados = seleccionados.filter(i => i !== interes);
            return;
        }

       
        if (seleccionados.length >= 3) {
            const primero = seleccionados.shift(); 
            primero.classList.remove('selected');
        }

        
        interes.classList.add('selected');
        seleccionados.push(interes);
    });
});
