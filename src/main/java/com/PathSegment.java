package com;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@ValidPathLength
public class PathSegment {

    @NotNull(message = "Path length cannot be null")
    private Integer lengthInMeters;

    @NotNull(message = "Block segment list cannot be null")
    @Valid
    private List<BlockSegment> blockSegments;

    public PathSegment(Integer lengthInMeters, List<BlockSegment> blockSegments) {
        this.lengthInMeters = lengthInMeters;
        this.blockSegments = blockSegments;
    }

    public Integer getLengthInMeters() {
        return lengthInMeters;
    }

    public List<BlockSegment> getBlockSegments() {
        return blockSegments;
    }
}

