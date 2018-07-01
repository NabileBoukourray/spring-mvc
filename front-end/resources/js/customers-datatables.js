import $ from "jquery";
import Dutch from "./../i18n/Dutch"

$(function () {

    const datatablesUrl = $("#datatablesUrl").val();
    var table = $("#customersDtId").DataTable({
        //"bProcessing": true,
        "responsive": true,
        "language": Dutch,
        "bServerSide": true,
        "sAjaxSource": datatablesUrl,
        "searching": false,
        "deferRender": true,
        "aLengthMenu": [10, 25, 50],
        "aoColumns": [
            {"mData": "customer_id"},
            {"mData": "store_id", "bSortable": true},
            {"mData": "first_name"},
            {"mData": "last_name"},
            {"mData": "email"},
            {"mData": "address_id"},
            {"mData": "active"},
            {"mData": "create_date"},
            {"mData": "last_update"}
        ],
        columnDefs: [ {
            targets: 4,
            render: (data)=>{
                return "<p>"+data+"</p>"
            }
        } ]
    });
});