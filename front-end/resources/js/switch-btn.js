import $ from "jquery";
import "./jquery.autocomplete.min";
import Switch from "./Switch";

const html1 = "<div class='d1 col-sm-12 mb-4'>" +
    "<div class='input-group'>" +
    "<div class='input-group-prepend w-25'>" +
    "<div class='input-group-text w-100'>Klant</div>" +
    "</div>" +
    "<div class='w-75'>" +
    "<input id='w-input-search' type='text' class='form-control'>" +
    "</div>" +
    "</div>" +
    "</div>";

const switchbtn = new Switch([
    {
        "classSelector": "d1",
        "beforeClass": "d2",
        "html": html1,
    }
]);

$(function () {

    switchbtn.initialize("Blokken", "Klant");
    $(".switch-btn").on("click", () => {
        switchbtn.switch("Blokken", "Klant");
    });

    $("#w-input-search").autocomplete({
        serviceUrl: "/getSuggetions",
        paramName: "tagName",
        delimiter: ",",
        transformResult: function(response) {

            return {
                //must convert json to javascript object before process
                suggestions: $.map($.parseJSON(response), function(item) {

                    return { value: item.customer_id, data: item.first_name };
                })

            };

        }

    });
    /** $( "#w-input-search" ).autocomplete( "option", "source", [ "c++", "java", "php", "coldfusion", "javascript", "asp", "ruby" ] ); */
})