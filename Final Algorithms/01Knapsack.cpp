#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int max(int a, int b) { return (a > b) ? a : b; }

void printknapSack(int W, int wt[], int val[], int n)
{
    int i, w;
    int K[n + 1][W + 1];

    // cout<<endl<<"Knapsack Table:"<<endl;

    for (i = 0; i <= n; i++)
    {
        for (w = 0; w <= W; w++)
        {
            if (i == 0 || w == 0)
            {
                K[i][w] = 0;
            }
            else if (wt[i - 1] <= w)
            {
                K[i][w] = max(val[i - 1] +
                                  K[i - 1][w - wt[i - 1]],
                              K[i - 1][w]);
            }
            else
            {
                K[i][w] = K[i - 1][w];
            }

            // cout<<K[i][w]<<" ";
        }
        // cout<<endl;
    }

    int res = K[n][W];
    cout << endl
         << "Maximum profits: " << res << endl;

    w = W;

    cout << endl
         << "Values: ";

    for (i = n; i > 0 && res > 0; i--)
    {

        if (res == K[i - 1][w])
            continue;
        else
        {

            cout << " " << val[i - 1];

            res = res - val[i - 1];
            w = w - wt[i - 1];
        }
    }
    cout << endl;
}

int main()
{
    int n, i, W;

    cout << "Enter items number: ";

    cin >> n;

    int val[n + 5], wt[n + 5];

    cout << "Enter the weight of items: ";
    for (i = 0; i < n; i++)
    {
        cin >> wt[i];
    }

    cout << "Enter the profit (value) of items: ";
    for (i = 0; i < n; i++)
    {
        cin >> val[i];
    }

    cout << "Enter Knapsack capacity: ";
    cin >> W;

    printknapSack(W, wt, val, n);

    return 0;
}
