package com.example.bankapp.service.exception;

public class ErrorMessage {
    public static final String ACCOUNT_NOT_FOUND_BY_STATUS = "Account with this status not found";

    public static final String ACCOUNT_NOT_FOUND_BY_ID_AND_STATUS = "Account with this id and status not found";

    public static final String ACCOUNTS_NOT_FOUND = "Any accounts were not found";

    public static final String CLIENT_NOT_FOUND_BY_STATUS_ACTIVE = "The client with the \"Active\" status was not found";
    public static final String CLIENT_NOT_FOUND_BY_BALANCE_MORE_THAN = "The client with such a balance will not be found";
}
