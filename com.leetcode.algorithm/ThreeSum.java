/*
* Find a triplet that sum to a given value.
*
* Given an array and a value, find if there is a triplet in array whose sum is equal to
* the given value. If there is such a triplet present in array, then print the triplet
* and return true. Else return false. For example, if the given array is {12, 3, 4, 1, 6, 9}
* and given sum is 24, then there is a triplet (12, 3 and 9) present in array whose sum is 24.
*/
public int[] getThreeSum(int[] input, int target) {
  int len = input.length;
  int[] result = new int[3];
  Arrays.sort(input);
  int j,k;
  for (int i=0;i< len - 2; i++) {
    j = i+1;
    k = len - 1;
    while(j<k){
      if(input[i]+input[j]+input[k]==target){
        result[0] = input[i];
        result[1] = input[j];
        result[2] = input[k];
        return result;
      }else if (input[i]+input[j]+input[k]<target) {
        j++;
      }else {
        k--;
      }
    }
  }
}

//if ask to see if you can find one
//complexity is N^2
public boolean hasThreeSum(int[] input, int target) {
  int len = input.length;
  int j,k;
  Arrays.sort(input);

  for(int i=0;i<len-2;i++){
    j=i+1;
    k=len-1;
    while(j<k){
      if(input[i]+input[j]+input[k]==target){
        return true;
      }else if(input[i]+input[j]+input[k]<target){
        l++;
      }else {
        k--;
      }
    }
  }
  return false;
}
