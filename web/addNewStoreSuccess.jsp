<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Store" %>
<!DOCTYPE html>
<html>
    <body>
        <!-- get session object movie -->
        <% Store store = (Store) session.getAttribute("store");%>
        <p>สินค้าที่เพิ่มได้แล้ว</p>
        ชื่อ: <%= store.getName() %><br/>
        ประเภท: <%= store.getType() %><br/>
        ตัวกรอง: <%= store.getFilter() %><br/>
        ตวามนิยม: <%= store.getPopularity() %><br/>
        ราคา: <%=store.getPrice() %><br/>
        <a href="updateStore.jsp">แก้ไขข้อมูลสินค้า</a>
    </body>
</html>
