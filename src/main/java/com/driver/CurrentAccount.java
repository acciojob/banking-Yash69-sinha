package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception.

        super(name,balance,5000);

        this.tradeLicenseId=tradeLicenseId;
        if (balance<5000)
        {
            throw new Exception("Insufficient Balance");
        }

    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception


        if(isValidLicence(tradeLicenseId)==false)
        {
            String rearrangeId=rearrangeString(tradeLicenseId);
            if(rearrangeId=="")
            {
                throw new Exception("Valid License can not be generated");
            }
            else
            {
                this.tradeLicenseId=rearrangeId;
            }
        }

    }
    public String rearrangeString(String s)
    {
        int [] freq=new int [26];
        char maxFreqChar=' ';
        int maxFrequency=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            freq[ch-'A']++;
            if(freq[ch-'A']>maxFrequency)
            {
                maxFreqChar=ch;
                maxFrequency=freq[ch-'A'];
            }
        }
        char[] result=new char[s.length()];
        int index=0;
        //putting the maxing frequency character
        while(freq[maxFreqChar-'A']-->0)
        {
            result[index]=maxFreqChar;
            index=index+2;
        }
        //Iterate over all the remaining character
        for(int i=0;i<26;i++)
        {
            int frequency=freq[i];
            while(frequency>0)
            {
                if(index>=s.length())
                {
                    index=1;
                }
                result[index]=(char)(i+'A');
                index=index+2;
            }
        }
        return result.toString();
    }
    public boolean isValidLicence(String licenceId)
    {
        for(int i=0;i<licenceId.length()-1;i++)
        {
            if(licenceId.charAt(i)==licenceId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }


}
