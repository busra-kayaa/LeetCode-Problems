// 1
int mySqrt(int x) {
    if (x == 0 || x == 1)
        return x;

    for (long i = 1; i <= x; i++) { 
        if (i * i == x)
            return i;
        else if (i * i > x)
            return i - 1;
    }
    return -1; // teorikte asla buraya gelmez
}

// Bu cozum de buyuk sayýlar ýcýn O(kok x) oldugu icin biraz yavas calisabilir

// 2 binary search
int mySqrt(int x) {

    if ( x == 0 || x == 1){
        return x;
    }

    long left = 1 , right = x/2, mid;

    while (left <= right) {

        mid = (left + right) / 2 ;
        long sq = mid *mid;

        if (sq == x) {
            return mid;
        }
        else if (sq > x){
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
    }
    return right;
}
// Bu cozum O(log x) hizinda calisir
