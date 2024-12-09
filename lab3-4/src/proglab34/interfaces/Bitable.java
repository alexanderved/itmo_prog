package proglab34.interfaces;

import proglab34.exceptions.BiteFailed;

public interface Bitable {
    void beBittenBy(Biter biter) throws BiteFailed;
}