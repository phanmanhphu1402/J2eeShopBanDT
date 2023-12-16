/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function confirmDeleteOrder(maHD){
    if(confirm("Delete ?")===true){
        window.location.href = "OrderManagerServlet?action=Delete&orderId="+maHD.toString();
    };
}

