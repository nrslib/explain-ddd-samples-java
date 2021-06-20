package sample._07_common_troubles._01;

import java.util.ArrayList;

public interface CircleQueryService {
    ArrayList<CircleSummary> GetSummaries(int page, int size);
}
