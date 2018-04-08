(function () {

    function formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
    
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;
    
        return [year, month, day].join('-');
    }
   
    document.addEventListener('DOMContentLoaded', function() {
        
        if(document.querySelector('#contObras') != null){
            imagesLoaded(contObras, function(){
                var elem = document.querySelector('.grid');
                var msnry = new Masonry( elem, {
                    itemSelector: '.grid-item',
                    columnWidth: '.grid-sizer',
                    percentPosition: true
                });
            });
        }
        
        if(document.querySelector('#rating') != null){
            rate.innerHTML = Number(rate.innerText).toFixed(2);

            btnLeer.addEventListener('click', () => {
                speechSynthesis.speak(new SpeechSynthesisUtterance(descripcion.innerText));
            })

            btnComment.addEventListener('click', function(){
                if(frmComment.txtTexto.value.trim().length == 0){
                    frmComment.txtTexto.classList.add('invalid');
                    M.toast({
                        html: 'Ingresa un comentario válido!',
                        classes: 'red darken-1 white-text',
                        displayLength: 1000
                    });
                    return;
                }else{
                    frmComment.txtTexto.classList.remove('invalid');
                }

                axios.post('/Pollock/comentar', {
                    "idObra": idObra.value,
                    "texto": frmComment.txtTexto.value.trim()
                })
                .catch(err => {
                    console.log(err);
                    M.toast({
                        html: 'Ha ocurrido un error :$',
                        classes: 'red darken-1 white-text',
                        displayLength: 1000
                    });
                })
                .then(res => {
                    let html = '', f = true;
                    if(res.data != false){
                        if(document.querySelectorAll('#comments .comment-item').length == 0){
                            comments.innerHTML = "";
                        }

                        comments.innerHTML += `
                        <li class="comment-item hoverable">
                            <div class="content">${res.data.texto}</div>
                            <div class="data">${formatDate(new Date())}</div>
                        </li>`;

                        html = 'Su comentario ha sido agregado éxitosamente!';
                        M.Modal.getInstance(mdlComment).close();
                        frmComment.txtTexto.value = "";
                    }else{
                        html = 'Ha ocurrido un error :$';
                        f = false;
                    }
                    M.toast({
                        html,
                        classes: `${f ? 'green' : 'red'} darken-1 white-text`,
                        displayLength: 1000
                    });
                });
            })

            rating.addEventListener('rate', () => {

                axios.post('/Pollock/Rate', {
                    "idObra": idObra.value,
                    "calificacion": rating.value
                })
                .then(res => {
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