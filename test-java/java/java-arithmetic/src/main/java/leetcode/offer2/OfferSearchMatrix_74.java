package leetcode.offer2;

public class OfferSearchMatrix_74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = searchColumn(matrix, target);
        if (rowIndex<0){
            return false;
        }
        return searchRow(matrix[rowIndex],target);
    }

    public int searchColumn(int[][] matrix,int target){
        int low =-1, height = matrix.length-1;
        while (low<height){
            int mid = low + (height-low+1)/2;
            if (matrix[mid][0]<= target){
                low = mid;
            }else {
                height = mid -1;
            }
        }
        return low;
    }

    public boolean searchRow(int[] row, int target){
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
