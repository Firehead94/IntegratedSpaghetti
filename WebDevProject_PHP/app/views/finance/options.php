Welcome, <?php echo $_SESSION['userinfo'][0]['USER_FIRST_NAME']?> <?php echo $_SESSION['userinfo'][0]['USER_LAST_NAME']?>!<br />


<input type="button" value="Make Payment" name="option" onclick="location.href ='payment'"/><br />
<input type="button" value="View Invoice" name="option" onclick="location.href ='invoices'"/>