#ifndef BROKER_H_INCLUDED
#define BROKER_H_INCLUDED
#include "Bank.h"
#include "Loan.h"


class Broker{
public:
 Loan &compareTwoBanks(Loan &obj1,Loan &obj2){
if(obj1.getInterestRate()<obj2.getInterestRate()){
return obj1;
}
return obj2;
}
Loan &compareThreeBanks(Loan &obj1,Loan &obj2,Loan &obj3){
if(obj1.getInterestRate()<=obj2.getInterestRate()&&obj1.getInterestRate()<=obj3.getInterestRate()){
return obj1;
}
else if(obj2.getInterestRate()<=obj1.getInterestRate()&&obj2.getInterestRate()<=obj3.getInterestRate()){

return obj2;
}
return obj3;
}

void display(Bank &obj){
obj.getInfo();
}

};

#endif // BROKER_H_INCLUDED
