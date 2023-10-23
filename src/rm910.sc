;;; Sierra Script 1.0 - (do not remove this comment)
(script# 910)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use CueObj)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm910 0
)

(local
	[local0 2]
	local2
	local3
	[local4 2]
	local6
)
(instance rm910 of LLRoom
	(properties
		picture 910
		east 905
	)
	
	(method (init)
		((Inv at: 22) state: 0)
		(Load rsVIEW 910)
		(Load rsVIEW 911)
		(Load rsVIEW 912)
		(Load rsVIEW 913)
		(super init:)
		(gLarry
			init:
			normalize:
			view: 911
			setLoop: 0
			setCycle: 0
			posn: 152 100 -5
			setCel: 0
			setPri: 7
		)
		(faucet init: cycleSpeed: 28 setCycle: Fwd)
		(drill init:)
		(light init:)
		(degree init:)
		(theWindow init:)
		(chair init:)
		(dentalTools init:)
		(sink init:)
		(mouthPic init:)
		(proc0_22 1)
		(proc0_3)
		(proc0_7 4)
		(chiChi init:)
		(switch gGNumber
			(915
				(chiChi
					view: 913
					posn: 185 105
					setLoop: 5
					setCel: 0
					cycleSpeed: 8
				)
				(if (proc0_6 51)
					(gLarry setCel: 1)
					(global2 setScript: sScored)
				else
					(gLarry setCel: 4)
					(= local2 25)
					(global2 setScript: sWorkOnTeeth)
				)
			)
			(else 
				(proc0_2)
				(gLongSong number: 910 loop: -1 play:)
				(global2 setScript: sBringInChiChi)
			)
		)
	)
	
	(method (doit)
		(super doit:)
		(return
			(if (!= local3 (GetTime 1))
				(= local3 (GetTime 1))
				(++ local2)
			else
				0
			)
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 910 0))
			(4
				(switch param2
					(21 (proc0_14 910 1))
					(else  (proc0_14 910 2))
				)
			)
			(5 (proc0_14 910 1))
			(10
				(proc0_14 910 3)
				(proc0_14 910 4 67 -1 185)
			)
			(1
				(proc0_2)
				(proc0_18 gLarry 910 5)
				(gLongSong fade:)
				(global2 newRoom: 905)
			)
			(3 (proc0_18 gLarry 910 6))
			(else  (proc0_14 910 7))
		)
	)
)

(instance faucet of Prop
	(properties
		x 225
		y 135
		description {the faucet}
		sightAngle 90
		lookStr {The faucet is drip-, drip-, dripping, right in time to the music that's playing!}
		view 910
		loop 1
		priority 8
		signal $4810
	)
)

(instance mouthPic of Feature
	(properties
		x 198
		y 48
		nsTop 33
		nsLeft 176
		nsBottom 63
		nsRight 221
		description {the happy tooth poster}
		sightAngle 40
		lookStr {If you maintained a regular schedule of oral hygiene with Chi Chi Lambada, your teeth would be happy too!}
	)
)

(instance drill of Feature
	(properties
		x 149
		y 33
		nsTop 19
		nsLeft 123
		nsBottom 47
		nsRight 175
		description {the drill}
		sightAngle 40
		lookStr {Whenever you see a high-speed dental drill, you make a silent vow to floss more often!}
	)
)

(instance sink of Feature
	(properties
		x 217
		y 132
		nsTop 118
		nsLeft 193
		nsBottom 146
		nsRight 242
		description {the sink}
		sightAngle 40
		lookStr {You love it when a woman orders you to "Spit!"}
	)
)

(instance dentalTools of Feature
	(properties
		x 124
		y 110
		nsTop 80
		nsLeft 80
		nsBottom 141
		nsRight 169
		description {the tray of dental tools}
		sightAngle 40
		lookStr {You've always believed dental professionals have latent masochistic tendencies.}
	)
)

(instance chair of Feature
	(properties
		x 160
		y 93
		nsTop 60
		nsLeft 119
		nsBottom 127
		nsRight 202
		description {the dentist's chair}
		sightAngle 40
		lookStr {You just love electric furniture!}
	)
)

(instance theWindow of Feature
	(properties
		x 93
		y 48
		nsTop 21
		nsLeft 81
		nsBottom 76
		nsRight 106
		description {the window}
		sightAngle 40
		lookStr {Through the window you see children laughing, skipping, running, playing; all oblivious to their oral hygiene!}
	)
)

(instance degree of Feature
	(properties
		x 123
		y 51
		nsTop 41
		nsLeft 112
		nsBottom 61
		nsRight 134
		description {Chi Chi's degree}
		sightAngle 40
		lookStr {Interesting. You never knew the Columbia School of Broadcasting even HAD a dental college!}
	)
)

(instance light of Feature
	(properties
		x 155
		y 50
		nsTop 43
		nsLeft 147
		nsBottom 58
		nsRight 163
		description {the spotlight}
		sightAngle 40
		lookStr {You love to peer at the reflection of your mouth on the surface of the dental spotlight.}
	)
)

(instance Chi_Chi_Lambada of Talker
	(properties
		nsTop 33
		nsLeft 22
		view 1910
		loop 3
		viewInPrint 1
		name "Chi Chi Lambada"
	)
	
	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1910
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 25
		nsLeft 34
		view 1910
		loop 2
		cycleSpeed 18
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 33
		nsLeft 27
		view 1910
	)
)

(instance sCloseUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= cycles 2))
			(1
				(chiChi setLoop: 5 setCel: 255 setCycle: Beg self)
			)
			(2 (global2 newRoom: 915))
		)
	)
)

(instance sBringInChiChi of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (proc0_2) (= ticks 60))
			(1
				(proc0_18 gLarry 910 8 108 self)
			)
			(2 (= ticks 60))
			(3
				(gLarry setCel: 1 cycleSpeed: 6)
				(= ticks 30)
			)
			(4 (proc0_14 910 9 108 self))
			(5 (= seconds 3))
			(6
				(chiChi
					view: 912
					setLoop: 1
					setCel: -1
					setCycle: Fwd
					cycleSpeed: 6
					setStep: 3 2
					moveSpeed: 6
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 185 105 self
				)
			)
			(7
				(chiChi
					view: 913
					setLoop: 1
					setCel: 0
					setCycle: 0
					setMotion: 0
				)
				(= ticks 30)
			)
			(8
				(proc0_18 Chi_Chi_Lambada 910 10 108 139 self)
			)
			(9
				(gLarry setCel: 0 stopUpd:)
				(= ticks 30)
			)
			(10
				(proc0_18 gLarry 910 11 67 -1 185)
				(= ticks 60)
			)
			(11
				(proc0_18 Chi_Chi_Lambada 910 12 108 139 self)
				(gLarry setCel: 2 stopUpd:)
			)
			(12 (= ticks 60))
			(13
				(chiChi
					view: 913
					setLoop: 5
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(gLarry setCel: 4 stopUpd:)
			)
			(14 (= seconds 4))
			(15
				(proc0_3)
				(User canControl: 0)
				(gLongSong2 stop:)
				(= local2 0)
				(= seconds 4)
			)
			(16
				(proc0_18 Chi_Chi_Lambada 910 13 108 139 self)
			)
			(17
				(global2 setScript: sWorkOnTeeth)
			)
		)
	)
)

(instance sWorkOnTeeth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(chiChi
					cycleSpeed: (Random 3 6)
					setLoop: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(if (and (> local2 30) (not local6))
					(proc0_18 Chi_Chi_Lambada 910 14 108 139 self)
					(= local6 1)
				else
					(= ticks 60)
				)
			)
			(2 (= ticks 30))
			(3 (chiChi setCycle: Beg self))
			(4 (= ticks 60))
			(5
				(if (> local2 35)
					(proc0_2)
					(proc0_18 Chi_Chi_Lambada 910 15 108 139 self)
					(chiChi
						setLoop: 5
						setCel: 255
						cycleSpeed: 8
						setCycle: Beg self
					)
					(gLongSong fade:)
				else
					(self init:)
				)
			)
			(6 0)
			(7 (global2 newRoom: 905))
		)
	)
)

(instance sDance of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= register 30) (self cue:))
			(1
				(= start state)
				(chiChi
					view: 913
					setLoop: (Random 2 4)
					setCycle: Fwd
					cycleSpeed: (Random 5 12)
				)
				(= ticks (Random 10 30))
			)
			(2
				(if (not (-- register))
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance chiChi of Actor
	(properties
		x 259
		y 105
		description {Chi Chi Lambada}
		sightAngle 90
		view 912
		priority 8
		signal $4810
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3 (proc0_14 910 16))
			(2
				(proc0_2)
				(global2 setScript: 0)
				(chiChi
					setLoop: 5
					setCel: 255
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(5 (proc0_14 910 1))
			(10
				(proc0_18 Chi_Chi_Lambada 910 17 108)
			)
			(1 (global2 doVerb: 1))
			(else  (proc0_14 910 1))
		)
	)
	
	(method (cue)
		(super cue:)
		(global2 newRoom: 915)
	)
)

(instance sScored of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (proc0_2) (= cycles 2))
			(1
				(gLarry setCel: 1)
				(self setScript: sDance self)
			)
			(2
				(chiChi setCycle: 0 stopUpd:)
				(proc0_10 40 165)
				(proc0_18 Chi_Chi_Lambada 910 18 108 139 self)
			)
			(3 (= ticks 90))
			(4
				(proc0_14 910 19 67 -1 185 70 280)
				(= ticks 123)
			)
			(5
				(global2 drawPic: 1 6)
				(= seconds 3)
			)
			(6
				(gLongSong fade:)
				(proc0_25 3 global128 910 20)
				(= seconds 3)
			)
			(7 (global2 newRoom: 920))
		)
	)
)
