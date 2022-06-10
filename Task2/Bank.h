#ifndef BANK_H_INCLUDED
#define BANK_H_INCLUDED


class Bank{
public:

string bankName;
string establishedDate;
string bankType;
string branchName;
virtual string getName(){}
virtual string getEstablishedDate(){}
virtual string getBankType(){}
virtual void getInfo(){}
virtual string getBranchName(){}




};


#endif // BANK_H_INCLUDED
