;;; Sierra Script 1.0 - (do not remove this comment)
(script# 22)
(include sci.sh)
(use Main)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	sPlugCharger 0
	sUnplugCharger 1
	sGetShocked 2
	charger 3
)

(local
	[local0 7] = [160 64 108 260 19 146]
)
(instance sPlugCharger of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gLarry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(= temp0 0)
				(while (!= [local0 temp0] 0)
					(if (== [local0 temp0] gNumber)
						(charger
							x: [local0 (++ temp0)]
							y: [local0 (++ temp0)]
							init:
						)
						(break)
					)
					(= temp0 (+ temp0 3))
				)
				(gLarry setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(3
				(gLarry put: 1 global2 setLoop: 1 normalize:)
				(proc0_10 8 65)
				(proc0_14 22 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sPlugCamcorder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gLarry setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(charger setLoop: 4)
				(gLarry setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(3
				(gLarry put: 0 (Inv at: 1) setLoop: 1 normalize:)
				(charger approachVerbs: 3 4 2)
				(proc0_10 3 66)
				(proc0_14 22 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sUnplugCharger of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(charger dispose:)
				(gLarry setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(2
				(gLarry setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(3
				(gLarry get: 1 get: 0 setLoop: 1 normalize:)
				((Inv at: 0) owner: 23)
				(charger setLoop: 3 approachVerbs: 3 4)
				(proc0_10 1 67)
				(if (== (charger loop?) 4)
					(proc0_14 22 2)
				else
					(proc0_14 22 3)
				)
				(proc0_3)
				(= temp0 (* 300 (/ global150 20)))
				(gCamcorderTimer setReal: gCamcorderTimer (/ temp0 100))
				(self dispose:)
			)
		)
	)
)

(instance sGetShocked of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					posn: (gLarry x?) (- (gLarry y?) 2)
					view: 560
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(shockSound number: 561 setLoop: 1 play:)
				(gLarry setPri: 13 setLoop: 1 setCycle: Fwd)
				(= cycles (Random 25 40))
			)
			(2
				(shockSound number: 147 play:)
				(gLarry setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gLarry setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(gLarry setLoop: 2 normalize:)
				(= ticks 60)
			)
			(5 (proc0_3) (self dispose:))
		)
	)
)

(instance shockSound of Sound
	(properties
		number 561
	)
)

(instance charger of View
	(properties
		description {the battery charger}
		view 161
		loop 3
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 3 4)
		(= approachX (+ x 12))
		(= approachY (+ y 1))
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 50])
		(switch theVerb
			(2
				(if (== ((Inv at: 0) owner?) (Inv at: 1))
					(Format @temp0 22 4 (/ global150 20) 37)
					(proc0_14 @temp0 30 1 80 {Camcorder Battery Strength})
				else
					(proc0_14 22 5)
				)
			)
			(3
				(global2 setScript: sUnplugCharger)
			)
			(4
				(switch param2
					(0
						(global2 setScript: sPlugCamcorder)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(10 (proc0_14 22 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
