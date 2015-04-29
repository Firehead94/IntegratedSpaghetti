<table>
    <thead>
        <th>Invoice ID</th>
        <th>Creditcard Number</th>
        <th>Student ID</th>
        <th>Invoice Payment</th>
        <th>Invoice Date</th>
    </thead>
    <tbody>
    <?php foreach ($_SESSION['invoiceinfo'] as $key => $val) { ?>
        <tr>
            <td><?php echo $val['INVOICE_ID'] ?></td>
            <td><?php echo $val['CREDITCARD_NUM'] ?></td>
            <td><?php echo $val['STU_ID'] ?></td>
            <td><?php echo $val['INVOICE_PAYMENT'] ?></td>
            <td><?php echo $val['INVOICE_DATE'] ?></td>
        </tr>
    <?php } ?>
    </tbody>
</table>
<br /><br />
<input type="button" value="Back to Options" onclick="location.href ='options'" />&nbsp;<input type="button" value="Close" onclick="window.close()" />

