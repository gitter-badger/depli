package com.depli.store.cache.descriptor;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * Thread Descriptor
 *
 * Entity to keep memory usage data observed from {@link
 * ManagementFactory#getThreadMXBean} of appropriate remote JMX connection in runtime.
 *
 * @author Lahiru Pathirage
 * @since 3/22/17
 */

public class ThreadDescriptor {

  /*
   * The current number of live daemon threads.
   */
  private int daemonThreadCount;

  /*
   * The peak live thread count.
   */
  private int peakThreadCount;

  /*
   * The current number of live threads including both daemon and non-daemon threads.
   */
  private int liveThreadCount;

  /*
   * The total number of threads created and also started since the Java virtual machine started.
   */
  private long totalStartedThreadCount;

  /*
   * The list of thread info for each thread with of stack trace elements.
   */
  private ThreadInfo[] threadInfoList;

  // default constructor
  public ThreadDescriptor() {
    daemonThreadCount = 0;
    peakThreadCount = 0;
    liveThreadCount = 0;
    totalStartedThreadCount = 0;
  }

  /**
   * Returns the current number of live daemon threads.
   *
   * @return the current number of live daemon threads
   */
  public int getDaemonThreadCount() {
    return daemonThreadCount;
  }

  /**
   * Sets the current number of live daemon threads.
   *
   * @param daemonThreadCount the current number of live daemon threads
   */
  public void setDaemonThreadCount(int daemonThreadCount) {
    this.daemonThreadCount = daemonThreadCount;
  }

  /**
   * Returns the peak live thread count since the Java virtual machine started or peak was reset.
   *
   * @return the peak live thread count
   */
  public int getPeakThreadCount() {
    return peakThreadCount;
  }

  /**
   * Sets the peak live thread count since the Java virtual machine started or peak was reset.
   *
   * @param peakThreadCount the peak live thread count
   */
  public void setPeakThreadCount(int peakThreadCount) {
    this.peakThreadCount = peakThreadCount;
  }

  /**
   * Returns the current number of live threads including both daemon and non-daemon threads.
   *
   * @return the current number of live threads
   */
  public int getLiveThreadCount() {
    return liveThreadCount;
  }

  /**
   * Sets the current number of live threads including both daemon and non-daemon threads.
   *
   * @param liveThreadCount the current number of live threads
   */
  public void setLiveThreadCount(int liveThreadCount) {
    this.liveThreadCount = liveThreadCount;
  }

  /**
   * Returns the total number of threads created and also started
   * since the Java virtual machine started.
   *
   * @return the total number of threads started
   */
  public long getTotalStartedThreadCount() {
    return totalStartedThreadCount;
  }

  /**
   * Sets the total number of threads created and also started
   * since the Java virtual machine started.
   *
   * @param totalStartedThreadCount the total number of threads started
   */
  public void setTotalStartedThreadCount(long totalStartedThreadCount) {
    this.totalStartedThreadCount = totalStartedThreadCount;
  }

  /**
   * Returns the list of thread info for each thread with of stack trace elements.
   *
   * @return a the list of thread info
   */
  public ThreadInfo[] getThreadInfoList() {
    return threadInfoList;
  }

  /**
   * Sets the list of thread info for each thread with of stack trace elements.
   *
   * @param threadInfoList a the list of thread info
   */
  public void setThreadInfoList(ThreadInfo[] threadInfoList) {
    this.threadInfoList = threadInfoList;
  }

  /**
   * Sets dynamic data fields.
   */
  public void setDynamicData(
      int daemonThreadCount,
      int peakThreadCount,
      int liveThreadCount,
      long totalStartedThreadCount,
      ThreadInfo[] threadInfoList
  ) {
    this.daemonThreadCount = daemonThreadCount;
    this.peakThreadCount = peakThreadCount;
    this.liveThreadCount = liveThreadCount;
    this.totalStartedThreadCount = totalStartedThreadCount;
    this.threadInfoList = threadInfoList;
  }

  /**
   * Returns count related fields as a map object.
   *
   * @return map object filled with counts
   */
  public Map<String, Integer> countsToMap() {
    Map<String, Integer> map = new HashMap<>();
    map.put("daemonThreadCount", daemonThreadCount);
    map.put("peakThreadCount", peakThreadCount);
    map.put("liveThreadCount", liveThreadCount);
    map.put("totalStartedThreadCount", (int) totalStartedThreadCount);

    return map;
  }

  /**
   * Returns thread dump data as a map object.
   *
   * @return map object filled with thread dump data
   */
  public Map dumpsToMap() {
    Map<String, ThreadInfo[]> map = new HashMap<>();
    map.put("threadInfoList", threadInfoList);
    return map;
  }
}
