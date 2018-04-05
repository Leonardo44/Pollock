(function () {
   
    document.addEventListener('DOMContentLoaded', function() {

        if(contObras != null){
            var elem = document.querySelector('.grid');
            var msnry = new Masonry( elem, {
                // set itemSelector so .grid-sizer is not used in layout
                itemSelector: '.grid-item',
                // use element for option
                columnWidth: '.grid-sizer',
                percentPosition: true
            });

            // element argument can be a selector string
            //   for an individual element
            var msnry = new Masonry( '.grid', {
                
            })
        }
        
        if(rating != null){

            rate.innerHTML = Number(rate.innerText).toFixed(2);

            btnLeer.addEventListener('click', () => {
                speechSynthesis.speak(new SpeechSynthesisUtterance(descripcion.innerText));
            })

            rating.addEventListener('rate', () => {

                axios.post('/Pollock/Rate', {
                    "idObra": idObra.value,
                    "calificacion": rating.value
                })
                .then(res => {
                    // console.log(res);
                    let html = '', f = true;
                    if(res.data != false){
                        rate.innerHTML = res.data.calificacion.toFixed(2);
                        rate.classList.add(res.data.calificacion > 2.5 ? 'green-text' : 'red-text');
                        rate.classList.remove(res.data.calificacion > 2.5 ? 'red-text' : 'green-text');
                        
                        html = 'Su voto ha sido agregado éxitosamente!';
                    }else{
                        html = 'Ha ocurrido un error :$';
                        f = false;
                    }

                    M.toast({
                        html,
                        classes: `${f ? 'green' : 'red'} darken-1 white-text`,
                        displayLength: 1000
                    });
                })
                .catch(err => {
                    console.log(err);
                    M.toast({
                        html: 'Ha ocurrido un error :$',
                        classes: 'red darken-1 white-text',
                        displayLength: 1000
                    });
                });

            })
        }
    });

})
();