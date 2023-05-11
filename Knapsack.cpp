// #include <bits/stdc++.h>
// using namespace std;

// int main()
// {
//     long long int n, W;

//     cout << "Enter items number: ";
//     cin >> n;
//     cout << "Enter Knapsack capacity: ";
//     cin >> W;

//     long long int w[n + 1];
//     long long int v[n + 1];
//     long long int dp[n + 1][W + 1];

//     cout << "Enter the weight of items: " << endl;
//     for (int i = 0; i < n; ++i)
//     {
//         cin >> w[i];
//     }

//     cout << "Enter the value(profits) of items: " << endl;
//     for (int i = 0; i < n; ++i)
//     {
//         cin >> v[i];
//     }
//     // putting 0 in 1st row
//     for (int i = 0; i <= W; ++i)
//     {
//         dp[0][i] = 0;
//     }
//     // putting 0 in 1st column
//     for (int i = 0; i <= n; ++i)
//     {
//         dp[i][0] = 0;
//     }

//     for (int i = 1; i <= n; ++i)
//     {
//         for (int j = 1; j <= W; ++j)
//         {
//             if (j >= w[i - 1])
//                 dp[i][j] = max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
//             else
//                 dp[i][j] = dp[i - 1][j];
//         }
//     }

//     cout << "Maximum profit: " << dp[n][W] << endl;
//     long long int x = dp[n][W];
//     long long int i = n, j = W;
    
//     cout << "values: ";
//     while (i > 0)
//     {
//         if (dp[i][j] == dp[i - 1][j])
//             i--;
//         else
//         {

//             cout << v[i - 1] << " ";
//             x -= v[i - 1];
//             i--;
//             if (i == 0)
//                 break;
//             for (int k = 0; k <= W; ++k)
//             {
//                 if (dp[i][k] == x)
//                     j = k;
//             }
//         }
//     }
// }

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int max(int a, int b) { return (a > b) ? a : b; }

void printknapSack(int W, int wt[], int val[], int n)
{
    int i, w;
    int K[n + 1][W + 1];

    cout<<endl<<"Knapsack Table:"<<endl;

    for (i = 0; i <= n; i++) {
        for (w = 0; w <= W; w++) {
            if (i == 0 || w == 0)
                {K[i][w] = 0;}
            else if (wt[i - 1] <= w)
                {K[i][w] = max(val[i - 1] +
                    K[i - 1][w - wt[i - 1]], K[i - 1][w]);}
            else
                {K[i][w] = K[i - 1][w];}

            cout<<K[i][w]<<" ";
        }
        cout<<endl;
    }

    int res = K[n][W];
    cout<<endl<<"Maximum profits: "<<  res << endl;

    w = W;

    cout<<endl<<"Values: ";

    for (i = n; i > 0 && res > 0; i--) {

        if (res == K[i - 1][w])
            continue;
        else {

            cout<<" "<<val[i - 1] ;

            res = res - val[i - 1];
            w = w - wt[i - 1];
        }
    } cout<<endl;
}


int main()
{
    int n,i,W;

    cout<<"Enter items number: ";   cin>>n;

    int val[n+5],wt[n+5];

    cout<<"Enter the weight of items: ";
    for(i=0;i<n;i++){cin>>wt[i];}

    cout<<"Enter the value of items: ";
    for(i=0;i<n;i++){cin>>val[i];}

    cout<<"Enter Knapsack capacity: ";
    cin>>W;

    printknapSack(W, wt, val, n);

    return 0;
}

/*
Input:
3
8 9 6
3 4 5
14

output:

Maximum values: 8
Values: 5 3
*/