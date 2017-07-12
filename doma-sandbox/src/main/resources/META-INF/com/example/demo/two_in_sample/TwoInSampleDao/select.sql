select
    /*%expand*/*
from
    two_in_sample
where
    (foo, bar) in (
/*%for a : condition */
    (/* a.foo */'x', /* a.bar */'y')
    /*%if a_has_next */
        /*# ", " */
    /*%end */
/*%end*/
)
order by
    foo, bar

