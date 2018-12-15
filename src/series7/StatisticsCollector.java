package series7;
// package programming.set7.statistics;

import java.lang.Math;
import java.util.ArrayList;

/**
 * a statistical nightmare.
 */
public class StatisticsCollector {

    /** Storage. */
    private ArrayList<Double> theList;

    /** make a thing.
     */
    public StatisticsCollector() {
        theList = new ArrayList<Double>();
    }

    /** addItem.
     * @param number a number to add
     */
    public void addItem(double number) {

        theList.add(number);

    }

    /** getCount.
     * @return how many elements there are
     */
    public int getCount() {

        return theList.size();

    }

    /** getSum.
     * @return the sum of all elements
     */
    public double getSum() {

        double sum = 0;

        for (Double el : theList) {
            sum += el;
        }

        return sum;

    }

    /** getMinimum.
     * @return the smallest element
     */
    public double getMinimum() {

        double min = Double.POSITIVE_INFINITY;

        for (Double el : theList) {
            if (el < min) {
                min = el;
            }
        }

        return min;

    }

    /** getMaximum.
     * @return the largest element
     */
    public double getMaximum() {

        double max = Double.NEGATIVE_INFINITY;

        for (Double el : theList) {
            if (el > max) {
                max = el;
            }
        }

        return max;

    }

    /** getAverage.
     * @return the average of all elements
     */
    public double getAverage() {

        // Edge case
        if (theList.size() < 1) return 0;

        return this.getSum() / theList.size();

    }

    /** getStandardDeviation.
     * @return the standard deviation.
     */
    public double getStandardDeviation() {

        // Just the size
        int size = theList.size();

        // Edge case
        if (size < 1) return 0;

        // The average of all
        double averageAllItems = this.getAverage();

        // The variance is...
        double variance = 0;

        // ...the average between the difference between the elements and the average of all elements squared

        for (Double el : theList) {
            // Difference between element and average of all elements
            double diff = averageAllItems - el;

            // Add the square of that to the variance
            variance += diff * diff;
        }

        // Take the average of the sums of squared differences
        variance /= size;

        // The Standard Deviation is the sqrt of the variance
        return Math.sqrt(variance);

    }

}
