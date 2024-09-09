<%-- 
    Document   : updateStore
    Created on : Jul 18, 2024, 3:54:52 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Store" %>
<!DOCTYPE html>
<html>
    <body>
        <% Store store = (Store) session.getAttribute("store");%>
        <p>แก้ไขข้อมูลสินค้า</p>
        <form action="addNewStoreServlet">
            <input type="text" name="storeName" value="<%= store.getName()%>"><br/>
            <input type="text" name="storeType" value="<%=store.getType()%>"<br/>
            <input type="text" name="storeFilter" value="<%=store.getFilter()%>"<br/>
            <input type="text" name="storePopularity" value="<%=store.getPopularity()%>"<br/>
            <input type="text" name="storePrice" value="<%=store.getPrice()%>"<br/>
            <input type="submit" value="แก้ไข">            
        </form>
        <% session.removeAttribute("store"); %>
    </body>
</html>

