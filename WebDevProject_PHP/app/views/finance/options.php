
<div style="display: inline-block; text-align: center; transform: translate(10%, 50%); zoom: 2">
    Welcome, <?php echo $_SESSION['userinfo'][0]['USER_FIRST_NAME']?> <?php echo $_SESSION['userinfo'][0]['USER_LAST_NAME']?>!<br />


    <input type="button" value="Make Payment" name="option" onclick="location.href ='payment'"/><br /><br />
    <input type="button" value="View Invoices" name="option" onclick="location.href ='invoices'"/>
</div>