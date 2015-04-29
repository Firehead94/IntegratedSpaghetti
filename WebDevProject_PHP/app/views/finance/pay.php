<form action="makepayment" method="post" style="display: inline-block; text-align: center; transform: translate(10%, 50%); zoom: 2">
    Current Balance: $<?php echo $_SESSION['balance'] ?>.00<br />
    <input type="number" name="amount" size="10" required /><br /><br /> 
    <input type="submit" value="Submit" />&nbsp;<input type="button" value="Cancel" onclick="window.close()" />
</form>