package com.android.ejemplos.demo;

import java.io.Serializable;




/** Represents the monthly payments and total payment amount
 *  for loans with a given principal, interest rate, and period. 
 *  It is Serializable so that it can be stored in a Bundle.
 */

public class InfoPago  {
    private final double mLoanAmount, mAnnualInterestRateInPercent, 
                         mMonthlyPayment, mTotalPayments;
    private final long mLoanPeriodInMonths;
    private final String mCurrencySymbol;
    
    public InfoPago(double loanAmount, double annualInterestRateInPercent,
                       long loanPeriodInMonths, String currencySymbol) {
        mLoanAmount = loanAmount;
        mAnnualInterestRateInPercent = annualInterestRateInPercent;
        mLoanPeriodInMonths = loanPeriodInMonths;
        mCurrencySymbol = currencySymbol;
        mMonthlyPayment = UtilesPrestamo.monthlyPayment(loanAmount, 
                                                   annualInterestRateInPercent, 
                                                   loanPeriodInMonths);
        mTotalPayments = mMonthlyPayment * mLoanPeriodInMonths;
    }
    
    public InfoPago(double loanAmount, double annualInterestRateInPercent,
                       long loanPeriodInMonths) {
        this(loanAmount, annualInterestRateInPercent, loanPeriodInMonths, "$");
    }

    public double getLoanAmount() {
        return(mLoanAmount);
    }
    
    public String getFormattedLoanAmount() {
        return(String.format("%s%,.2f", mCurrencySymbol, mLoanAmount));
    }

    public double getAnnualInterestRateInPercent() {
        return(mAnnualInterestRateInPercent);
    }
    
    public String getFormattedAnnualInterestRateInPercent() {
        return(String.format("%,.2f%%", mAnnualInterestRateInPercent));
    }

    public long getLoanPeriodInMonths() {
        return(mLoanPeriodInMonths);
    }
    
    public String getFormattedLoanPeriodInMonths() {
        return(String.format("%s", mLoanPeriodInMonths));
    }
    
    public String getCurrencySymbol() {
        return(mCurrencySymbol);
    }

    public double getMonthlyPayment() {
        return (mMonthlyPayment);
    }
    
    public String getFormattedMonthlyPayment() {
        return(String.format("%s%,.2f", mCurrencySymbol, mMonthlyPayment));
    }

    public double getTotalPayments() {
        return (mTotalPayments);
    }

    public String getFormattedTotalPayments() {
        return(String.format("%s%,.2f", mCurrencySymbol, mTotalPayments));
    }
}
