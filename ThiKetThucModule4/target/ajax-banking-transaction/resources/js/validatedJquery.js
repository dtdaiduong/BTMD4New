$(document).ready(function () {
    //validated form Create
    $("#frmCreate").validate({
        rules: {
            fullNameCreate: {
                required: true,
                minlength: 5,
                maxlength: 30
            },
            emailCreate: {
                required: true,
                email: true,
                minlength: 10,
                maxlength: 50
            },
            phoneCreate: {
                required: true,
                minlength: 9
            }
        },
        messages: {
            fullNameCreate: {
                required: "Full name is required",
                minlength: "Full name min length 5 character",
                maxlength: "Full name max length 30 character"
            },
            emailCreate: {
                required: "Email is required",
                email: "Email not valid",
                minlength: "Email min length 10 character",
                maxlength: "Email max length 50 character"
            },
            phoneCreate: {
                required: "Phone number is required",
                minlength: "Phone number invalid"
            }
        },
        errorLabelContainer: '#modalCreate .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalCreate .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalCreate .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalCreate .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalCreate input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            createCustomer();
        }
    });

    //validated form Update
    $("#frmUpdate").validate({
        rules: {
            fullNameUp: {
                required: true,
                minlength: 5,
                maxlength: 30
            },
            emailUp: {
                required: true,
                email: true,
                minlength: 10,
                maxlength: 50
            },
            phoneUp: {
                required: true,
                minlength: 9
            }
        },
        messages: {
            fullNameUp: {
                required: "Full name is required",
                minlength: "Full name min length 5 character",
                maxlength: "Full name max length 30 character"
            },
            emailUp: {
                required: "Email is required",
                email: "Email not invalid",
                minlength: "Email min length 5 character",
                maxlength: "Email max length 30 character"
            },
            phoneUp: {
                required: "Phone number is required",
                minlength: "Phone number invalid"
            }
        },
        errorLabelContainer: '#modalUpdate .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalUpdate .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalUpdate .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalUpdate .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalUpdate input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            updateCustomer();
        }
    });

    //validated form Deposit
    $("#frmDeposit").validate({
        rules: {
            transactionDeposit: {
                required: true,
                // min: 50,
            }
        },
        messages: {
            transactionDeposit: {
                transactionDeposit: "Transaction amount is required",
                // min: "Min to deposit must be larger 50$",
            }
        },
        errorLabelContainer: '#modalDeposit .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalDeposit .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalDeposit .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalDeposit .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalDeposit input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            depositCustomer();
        }
    });

    //validated form Withdraw
    $("#frmWithdraw").validate({
        rules:{
            transactionWithdraw: {
                required: true,
                // min: 50
            }
        },
        messages: {
            transactionWithdraw: {
                required: "Transaction amount is required",
                // min: "Min to withdraw must be larger 50$",
            }
        },
        errorLabelContainer: '#modalWithdraw .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalWithdraw .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalWithdraw .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalWithdraw .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalWithdraw input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            withdrawCustomer();
        }
    });

    //validated form Transfer
    $("#frmTransfer").validate({
        rules: {
            transferAmount: {
                required: true,
                // min: 50
            }
        },
        messages: {
            transferAmount: {
                required: "Transfer amount is required",
                // min: "Min to transfer must be larger 50$",
            }
        },
        errorLabelContainer: '#modalTransfer .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalTransfer .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalTransfer .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalTransfer .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalTransfer input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            transferCustomer();
        }
    });
})