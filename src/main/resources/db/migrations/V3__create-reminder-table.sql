CREATE TABLE reminder (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    notify_at TIMESTAMP NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_bill FOREIGN KEY (bill_id) REFERENCES bill (id) ON DELETE CASCADE,
)