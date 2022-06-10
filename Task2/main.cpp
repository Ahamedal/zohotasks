#include <iostream>

using namespace std;

#include "Bank.h"
#include "Loan.h"
#include "HDFC.h"
#include "ICICI.h"
#include "SBI.h"
#include "Broker.h"

int main()
{
    //cout << "Hello world!" << endl;
   HDFC h("HDFC","1-2-2000","Private","Ramnad",15);

    SBI s("SBI","1-2-1999","Public","Karaikudi",20);

    ICICI i("ICICI","1-2-2001","Private","Chennai",10);
   Broker b;



    cout<<b.compareTwoBanks(h,s).getName()<<" has lowest Bank interestRate"<<endl;
    cout<<b.compareThreeBanks(h,s,i).getName()<<" has lowest Bank intersetRate";

    b.display(h);

    //b.allDisplay();
    return 0;
}
