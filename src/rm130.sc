;;; Sierra Script 1.0 - (do not remove this comment)
(script# 130)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n958)
(use Sound)
(use PicView)
(use Obj)

(public
	rm130 0
)

(local
	[local0 2]
	local2
)
(instance rm130 of LLRoom
	(properties
		picture 130
	)
	
	(method (init)
		(proc958_0 128 130 1130)
		(proc958_0 132 130 140)
		(proc0_2)
		(cigar init: setPri: 15 addToPic:)
		(vMouth init: setPri: 13 addToPic:)
		(brow1 init: addToPic:)
		(brow2 init: addToPic:)
		(gAddToPics doit:)
		(super init:)
		(proc0_13 155)
		(gLongSong number: 130 flags: 1 loop: 0 play:)
		(self setScript: sCartoon)
		(gLl5KDHandler add: sCartoon)
		(gLl5MDHandler add: sCartoon)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: sCartoon)
		(gLl5KDHandler delete: sCartoon)
		(super dispose:)
		(gLongSong fade: 0 15 12 1)
	)
)

(instance vMouth of View
	(properties
		x 154
		y 129
		view 1130
	)
)

(instance brow1 of View
	(properties
		x 127
		y 53
		view 130
	)
)

(instance brow2 of View
	(properties
		x 179
		y 55
		view 130
		loop 1
	)
)

(instance cigar of View
	(properties
		x 201
		y 104
		view 130
		loop 3
	)
)

(instance officeHit of Sound
	(properties
		number 130
	)
)

(instance Mr__Bigg of Talker
	(properties
		x -1
		y 10
		nsTop 79
		nsLeft 111
		view 1130
		loop 3
		priority 14
		signal $0010
		talkWidth 280
		name "Pan Bigg"
	)
	
	(method (init)
		(= mouth biggMouth)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit:)
		(if (not (mod (++ local2) 6)) (Palette 6 206 254 -1))
	)
	
	(method (show &tmp temp0)
		(if (not underBits)
			(= underBits
				(Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1)
			)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(if bust
			(DrawCel
				(bust view?)
				(bust loop?)
				(bust cel?)
				(+ (bust nsLeft?) nsLeft)
				(+ (bust nsTop?) nsTop)
				14
			)
		)
		(if eyes
			(DrawCel
				(eyes view?)
				(eyes loop?)
				(eyes cel?)
				(+ (eyes nsLeft?) nsLeft)
				(+ (eyes nsTop?) nsTop)
				14
			)
		)
		(if mouth
			(DrawCel
				(mouth view?)
				(mouth loop?)
				(mouth cel?)
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				14
			)
		)
		(DrawCel view loop cel nsLeft nsTop 10)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)
	
	(method (cycle param1 &tmp temp0)
		(if (and param1 (param1 cycler?))
			(= temp0 (param1 cel?))
			((param1 cycler?) doit:)
			(if (!= temp0 (param1 cel?))
				(DrawCel
					(param1 view?)
					(param1 loop?)
					(param1 cel?)
					(+ (param1 nsLeft?) nsLeft)
					(+ (param1 nsTop?) nsTop)
					14
				)
				(param1
					nsRight:
						(+
							(param1 nsLeft?)
							(CelWide (param1 view?) (param1 loop?) (param1 cel?))
						)
				)
				(param1
					nsBottom:
						(+
							(param1 nsTop?)
							(CelHigh (param1 view?) (param1 loop?) (param1 cel?))
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (param1 nsTop?) nsTop)
					(+ (param1 nsLeft?) nsLeft)
					(+ (param1 nsBottom?) nsTop)
					(+ (param1 nsRight?) nsLeft)
					1
				)
			)
		)
	)
)

(instance biggMouth of Prop
	(properties
		view 1130
		priority 14
		signal $0010
		cycleSpeed 10
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_18 Mr__Bigg 130 0 108 139 self)
			)
			(2 (= seconds 3))
			(3
				(gIconBar disable:)
				(DrawPic 1 -32762)
				(= seconds 3)
			)
			(4
				(gIconBar enable:)
				(proc0_25 3 global128 130 1)
				(= seconds 3)
			)
			(5 (global2 newRoom: 140))
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 2])
		(if
			(and
				(== (self state?) 4)
				(or
					(== (pEvent type?) evKEYBOARD)
					(== (pEvent type?) evMOUSEBUTTON)
				)
			)
			(pEvent claimed: 1)
			(self changeState: 5)
		)
	)
)
