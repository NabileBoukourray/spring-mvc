import $ from "jquery";
import axios from "axios";

$(function(){
    const totalPages = $("#totalPagesId").val();

    if(totalPages >= 1) {
        $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            onPageClick: function (event, num) {

                axios.get("/api/films",
                    {
                        params: {
                            page: num,
                            size: 10
                        }
                    })
                    .then(function (response) {
                        //if response not empty

                        let ht = "";

                        response.data.map(film => {
                            ht += "" +
                                "<tr>" +
                                "<td>" + film.film_id + "</td>" +
                                "<td>" + film.title + "</td>" +
                                "<td>" + film.description + "</td>" +
                                "<td>" + film.special_features + "</td>" +
                                "<td>" + film.release_year + "</td>" +
                                "<td>" + film.length + "</td>" +
                                "<td>" + film.last_update + "</td>"+
                                "</tr>";
                        });
                        $('#page-content').html(ht);

                    }).then(()=>{
                        $("#myTableId").removeClass("invisible");
                    })
                    .catch(function (error) {
                        console.log(error);
                    });

            }
        });
    }
});