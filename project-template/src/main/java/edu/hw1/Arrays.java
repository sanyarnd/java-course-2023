package edu.hw1;

public class Arrays {
    public static boolean attachedArray(int[] a, int lenA, int[] b, int lenB ){
        int minLength = Math.min(lenA, lenB);
        int minA, maxA, minB, maxB;
        minA = maxA = a[0];
        minB = maxB = b[0];
        for(int i = 1; i < minLength; i += 1){
            if (a[i] > maxA)
                maxA = a[i];
            if (a[i] < minA)
                minA = a[i];

            if (b[i] > maxB)
                maxB = b[i];
            if (b[i] < minB)
                minB = b[i];
        }
        if (lenA > lenB)
            for (int i = minLength +1; i < lenA; i += 1)
            {
                if (a[i] > maxA)
                    maxA = a[i];
                if (a[i] < minA)
                    minA = a[i];
            }
        if (lenB > lenA)
            for (int i = minLength +1; i < lenB; i += 1)
            {
                if (b[i] > maxB)
                    maxB = b[i];
                if (b[i] < minB)
                    minB = b[i];
            }
        return minA > minB && maxA < maxB;
    }
}
