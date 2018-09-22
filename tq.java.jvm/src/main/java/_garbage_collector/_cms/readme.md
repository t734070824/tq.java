

### FULL GC
4. CMS 不等于Full GC，我们可以看到CMS分为多个阶段，只有stop the world的阶段被计算到了Full GC的次数和时间，而和业务线程并发的GC的次数和时间则不被认为是Full GC
5. Full GC的次数说的是stop the world的次数，所以一次**CMS至少会让Full GC的次数+2**，因为CMS Initial mark和remark都会stop the world，记做2次。而CMS可能失败再引发一次Full GC
6. **CMSScavengeBeforeRemark**:执行CMS remark之前进行一次youngGC，这样能有效降低remark的时间




