package cart.service.coupon;

import cart.auth.Credentials;
import cart.domain.coupon.Coupon;
import cart.domain.coupon.CouponRepository;
import cart.domain.member.Member;
import cart.domain.member.MemberRepository;
import cart.exception.CannotChangeCouponStatusException;
import cart.exception.CannotDeleteCouponException;
import cart.repository.MemberJdbcRepository;
import cart.service.dto.CouponReissueRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CouponService {

    private final CouponRepository couponRepository;
    private final MemberRepository memberRepository;

    public CouponService(final CouponRepository couponRepository, final MemberJdbcRepository memberRepository) {
        this.couponRepository = couponRepository;
        this.memberRepository = memberRepository;
    }

    public Long issueCoupon(final Credentials credentials, final Long couponId) {
        final Member member = new Member(credentials.getId(), credentials.getEmail(), credentials.getPassword());
        return couponRepository.issue(member, couponId);
    }

    public void reissueCoupon(final Long couponId, final CouponReissueRequest request) {
        final Member member = memberRepository.findMemberByMemberIdWithCoupons(request.getId());
        final Coupon coupon = member.findCoupon(couponId);

        if (coupon.isNotUsed()) {
            throw new CannotChangeCouponStatusException();
        }

        couponRepository.changeStatusTo(couponId, Boolean.FALSE);
    }

    public void deleteCoupon(final Long couponId) {
        final Coupon coupon = couponRepository.findCouponById(couponId);

        if (coupon.isNotUsed()) {
            throw new CannotDeleteCouponException();
        }

        couponRepository.deleteCoupon(coupon.getId());
    }
}
